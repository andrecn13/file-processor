package com.andrenunes.fileprocessor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("file")
public class DirectoryProperties {

    private String DirectoryIn;
    private String DirectoryOut;
    private String ExtensionIn;
    private String ExtensionOut;

    public String getDirectoryIn() {
        return DirectoryIn;
    }

    public void setDirectoryIn(String directoryIn) {
        DirectoryIn = directoryIn;
    }

    public String getDirectoryOut() {
        return DirectoryOut;
    }

    public void setDirectoryOut(String directoryOut) {
        DirectoryOut = directoryOut;
    }

    public String getExtensionIn() {
        return ExtensionIn;
    }

    public void setExtensionIn(String extensionIn) {
        ExtensionIn = extensionIn;
    }

    public String getExtensionOut() {
        return ExtensionOut;
    }

    public void setExtensionOut(String extensionOut) {
        ExtensionOut = extensionOut;
    }
}
