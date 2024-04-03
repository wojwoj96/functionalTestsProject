package org.wojciech.helper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Data
@RequiredArgsConstructor
public class ScenarioContext {
    private final Map<String, Object> scenarioVariables = new HashMap<>();

    public ScenarioContext setVariable(Context variableName, Object variableValue) {
        this.scenarioVariables.put(String.valueOf(variableName.name()), variableValue);
        return this;
    }

    public <T> T getVariableValue(final Context variableName) {
        if(!scenarioVariables.containsKey(variableName.name())) {
            throw new RuntimeException("Context with variable name " + variableName + " was not initialized");
        }
        return (T) scenarioVariables.get(variableName.name());
    }

    public void clear() { this.scenarioVariables.clear(); }
    private String getValueFromVariable(String variableName) {
        return Arrays.asList(variableName.split("(?<=})")).stream().map(vn -> {
            String formattedVariable = StringUtils.substringBetween(vn, "${", "}");
            String variableValue = (String) scenarioVariables.get(formattedVariable);
            return StringUtils.replace(vn, format("${%s}", formattedVariable), variableValue);
        }).collect(Collectors.joining());
    }
}
