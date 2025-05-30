package com.philips.healthsuite.workflowcapability.core;
import com.philips.healthsuite.workflowcapability.core.demos.*;
import org.apache.jena.base.Sys;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
@EnableAsync
public class WfcServiceApplication {
    static Logger logger =  Logger.getLogger(WfcServiceApplication.class.getName());
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("com.philips.healthsuite.workflowcapability.core.demos");
            context.refresh();
            FhirStoreInitialization fhirStoreInitialization = context.getBean(FhirStoreInitialization.class);
            if (args.length > 0) {
                List<String> argsList = List.of(args);
                if (argsList.contains("withAllDemos")) {
                   logger.info("Running Preprocessing Step (all demos)");
                    context.getBean(DemoCreator1.class).run();
                    context.getBean(DemoCreator2.class).run();
                    context.getBean(DemoCreator3.class).run();
                    context.getBean(DemoCreator4.class).run();
                    context.getBean(DemoCreator5.class).run();
                    context.getBean(DemoCreator6.class).run();
                    context.getBean(DemoCreator7.class).run();
                    context.getBean(DemoCreator8.class).run();
                    context.getBean(DemoCreator9.class).run();
                    context.getBean(DemoCreator10.class).run();
                } else if (argsList.contains("withSepsisV2Demos")) {
                   logger.info("Running Preprocessing Step (sepsis v2 demos)");
                    context.getBean(DemoCreator5.class).run();
                    context.getBean(DemoCreator6.class).run();
                    context.getBean(DemoCreator7.class).run();
                    context.getBean(DemoCreator8.class).run();
                    context.getBean(DemoCreator9.class).run();
                    context.getBean(DemoCreator10.class).run();
                } else {
                    if (argsList.contains("withPreprocessing1")) {
                       logger.info("Running Preprocessing Step (demo data 1)");
                        DemoCreator1 ms = context.getBean(DemoCreator1.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing2")) {
                       logger.info("Running Preprocessing Step (demo data 2)");
                        DemoCreator2 ms = context.getBean(DemoCreator2.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing3")) {
                       logger.info("Running Preprocessing Step (demo data 3)");
                        DemoCreator3 ms = context.getBean(DemoCreator3.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing4")) {
                       logger.info("Running Preprocessing Step (demo data 4)");
                        DemoCreator4 ms = context.getBean(DemoCreator4.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing5")) {
                       logger.info("Running Preprocessing Step (demo data 5)");
                        DemoCreator5 ms = context.getBean(DemoCreator5.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing6")) {
                       logger.info("Running Preprocessing Step (demo data 6)");
                        DemoCreator6 ms = context.getBean(DemoCreator6.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing7")) {
                       logger.info("Running Preprocessing Step (demo data 7)");
                        DemoCreator7 ms = context.getBean(DemoCreator7.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing8")) {
                       logger.info("Running Preprocessing Step (demo data 8)");
                        DemoCreator8 ms = context.getBean(DemoCreator8.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing9")) {
                       logger.info("Running Preprocessing Step (demo data 9)");
                        DemoCreator9 ms = context.getBean(DemoCreator9.class);
                        ms.run();
                    }
                    if (argsList.contains("withPreprocessing10")) {
                       logger.info("Running Preprocessing Step (demo data 10)");
                        DemoCreator10 ms = context.getBean(DemoCreator10.class);
                        ms.run();
                    }
                }
            }

            // FhirStoreInitialization fhirStoreInitialization = context.getBean(FhirStoreInitialization.class);
            // fhirStoreInitialization.run();
            else{
                logger.info("No arguments provided. Running with default preprocessing step" );
                fhirStoreInitialization.run();
               logger.info("Preprocessing step completed");
            }
        
        } catch (BeansException | IllegalStateException e) {
            logger.severe("An error occured while running the preprocessing step");
            e.printStackTrace();
        }
        // set the system property to prefer IPv4 stack to avoid issues with IPv6 stack on some systems (e.g. Windows) 
        System.setProperty("java.net.preferIPv4Stack", "true");
        SpringApplication.run(WfcServiceApplication.class, args);
    }

}
