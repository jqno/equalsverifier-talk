package nl.jqno.equalsverifier.talk.helper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@Nonnull
@TypeQualifierDefault({ ElementType.FIELD })
@Retention(RetentionPolicy.CLASS)
public @interface NonNullByDefault {}