package app.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // disponível em tempo de execução
@Target(ElementType.TYPE)             // só pode ser usada em classes
public @interface InfoAutor {
    String nome();

    String data();
}
