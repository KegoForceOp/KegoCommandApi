package me.kego.Command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {

    public String name();
    public String[] aliases() default "";
    public String desc();
    public String usage();
    public boolean blatant() default false;

}
