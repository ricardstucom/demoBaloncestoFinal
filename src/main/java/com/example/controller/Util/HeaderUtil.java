package com.example.controller.Util;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * Created by 46989075y on 18/11/2016.
 */
public final class HeaderUtil {

    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);

             private HeaderUtil() {
            }

             public static HttpHeaders createAlert(String message, String param) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("X-BaloncestoApp-alert", message);
                headers.add("X-BaloncestoApp-params", param);
                return headers;
           }

             public static HttpHeaders createEntityCreationAlert(String entityName, String param) {
                return createAlert("BaloncestoApp." + entityName + ".created", param);
            }

             public static HttpHeaders createEntityUpdateAlert(String entityName, String param) {
                return createAlert("BaloncestoApp." + entityName + ".updated", param);
            }

             public static HttpHeaders createEntityDeletionAlert(String entityName, String param) {
               return createAlert("BaloncestoApp." + entityName + ".deleted", param);
            }

             public static HttpHeaders createFailureAlert(String entityName, String errorKey, String defaultMessage) {
                log.error("Entity creation failed, {}", defaultMessage);
                HttpHeaders headers = new HttpHeaders();
                headers.add("X-BaloncestoApp-error", "error." + errorKey);
                headers.add("X-BaloncestoApp-params", entityName);
                headers.add("X-BaloncestoApp-error-message",defaultMessage);
                return headers;
            }
 }

