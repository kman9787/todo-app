package dev.kash.todoapp.config.annotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
public class FeatureToggleLapseDateTimeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = getMetadataAttribute(metadata, "name");
        String format = getMetadataAttribute(metadata, "format");
        String defaultValue = getMetadataAttribute(metadata, "defaultValue");
        String featureToggleDateStr = context.getEnvironment().getProperty(property, defaultValue);

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDateTime localDateTime = LocalDateTime.parse(featureToggleDateStr, formatter);
            return localDateTime.isBefore(LocalDateTime.now()) || localDateTime.isEqual(LocalDateTime.now());
        } catch (Exception e) {
            log.warn("Failed to evaluate the feature toggle conditional annotation. property: {}, value: {}, format: {}",
                    property, featureToggleDateStr, format);
        }

        return false;
    }

    private String getMetadataAttribute(AnnotatedTypeMetadata metadata, String name){
        final String className =  ConditionalOnLapseDateTimeProperty.class.getName();
        Optional<AnnotatedTypeMetadata> metadataOptional = Optional.ofNullable(metadata);
        return metadataOptional.map(metadataItem -> metadataItem.getAnnotationAttributes(className))
                .map(attrMap -> attrMap.get(name))
                .orElse("")
                .toString();
    }
}
