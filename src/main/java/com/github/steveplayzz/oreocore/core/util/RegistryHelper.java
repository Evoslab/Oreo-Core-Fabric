package com.github.steveplayzz.oreocore.core.util;

import com.github.steveplayzz.oreocore.core.OreoCore;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Locale;

public class RegistryHelper {

    @SafeVarargs
    public static <T> void register(Registry<T> registry, Class typeClass, Class from, RegistryCallback<T>... callbacks)
    {
        try {
            Field[] fields = from.getDeclaredFields();

            for (Field field : fields) {
                if (typeClass.isAssignableFrom(field.getType()) && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {

                    T value = (T)field.get(from);
                    String regName = field.getName().toLowerCase(Locale.ENGLISH);
                    Identifier id = OreoCore.ID(regName);

                    Registry.register(registry, id, value);

                    for (RegistryCallback<T> cb : callbacks)
                    {
                        cb.callback(registry, value, id);
                    }
                }
            }

        }
        catch (Exception e)
        {
            //if crash == true; dont();
            e.printStackTrace();
        }
    }

    public interface RegistryCallback<T>
    {
        void callback(Registry<T> registry, T registryObject, Identifier identifier);
    }

    private RegistryHelper(){}

}
