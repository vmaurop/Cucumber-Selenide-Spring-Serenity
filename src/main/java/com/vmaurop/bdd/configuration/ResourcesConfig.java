package com.vmaurop.bdd.configuration;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;



public class ResourcesConfig {

    public String getEnvironmentProperties() {
        return getAbsolutePath() + getPomProperty("env.properties");
    }

    public String getAbsolutePath() {
        String absPath = Paths.get(".")
                              .toAbsolutePath().normalize().toString().replace("\\", "/");

        String modulePath = this.getClass().getClassLoader().getResource(".").getPath();
        modulePath = modulePath.replace("\\", "/");
        modulePath = modulePath.replace("/target/test-classes", "");
        modulePath = modulePath.replace("/target/classes", "");
        modulePath = modulePath.replace(absPath, "");
        modulePath = modulePath.replace("//", "/");

        return absPath + modulePath;
    }

    private String getPomProperty(String propertyName) {
        Model model = null;
        MavenXpp3Reader reader = new MavenXpp3Reader();
        try {
            model = reader.read(new FileReader(getAbsolutePath() + "/pom.xml"));
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return model.getProperties().getProperty(propertyName);
    }

}
