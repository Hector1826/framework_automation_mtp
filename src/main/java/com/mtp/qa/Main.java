package com.mtp.qa;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Main {
    /**
     * @param args
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        /** 
         *  Definimos los parametros para realizar la sesión con Appium
         *  usamos la clase <code>DesiredCapabilities</code>
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); // Plataforma
        capabilities.setCapability("appium:automationName", "UiAutomator2"); // Nombre del driver
        // Ruta de donde se encuentra la app que se requiere instalar. 
        String appUrl = System.getProperty("user.dir") + File.separator + 
                        "src" + File.separator + 
                        "main" + File.separator + 
                        "resources" + File.separator + 
                        "ApiDemos-debug.apk";
        capabilities.setCapability("appium:app", appUrl);
        /**
         * Dispositivo fisico / Emulador
         */
        capabilities.setCapability("appium:udid", "988820383739513452"); //Dispositivo fisico
        capabilities.setCapability("appium:udid", "emulator-5556"); // Dispositivo Emulador
        
        // Dirección del servidor Appium
        URL url = new URL("http://0.0.0.0:4723");

        // Llamado del driver para dispositivos Android
        new AndroidDriver(url, capabilities);
    }
}