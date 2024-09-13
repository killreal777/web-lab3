package area.util;

import jakarta.servlet.ServletContextListener;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

public class MBeanRegistryUtil implements ServletContextListener {
    private static final Map<Class<?>, ObjectName> BEANS = new HashMap<>();

    public static void registerBean(Object bean, String name) {
        try {
            String domain = bean.getClass().getPackageName();
            String type = bean.getClass().getSimpleName();
            ObjectName objectName = new ObjectName(String.format("%s:type=%s,name=%s", domain, type, name));
            ManagementFactory.getPlatformMBeanServer().registerMBean(bean, objectName);
            BEANS.put(bean.getClass(), objectName);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException |
                 MalformedObjectNameException ex) {
            ex.printStackTrace();
        }
    }

    public static void unregisterBean(Object bean) {
        if (!BEANS.containsKey(bean.getClass())) {
            throw new IllegalArgumentException("Specified bean is not registered.");
        }
        try {
            ObjectName objectName = BEANS.get(bean.getClass());
            ManagementFactory.getPlatformMBeanServer().unregisterMBean(objectName);
        } catch (InstanceNotFoundException | MBeanRegistrationException ex) {
            ex.printStackTrace();
        }
    }
}