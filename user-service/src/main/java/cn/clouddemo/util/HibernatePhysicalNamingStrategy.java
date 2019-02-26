package cn.clouddemo.util;

import org.springframework.util.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import javax.persistence.MappedSuperclass;

/**
 * Created by shenzx on 2019/2/16.
 */
@MappedSuperclass
public class HibernatePhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl{

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
        return new Identifier(identifier.getText(),identifier.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment context) {
        return convert(identifier);
    }

    private Identifier convert(Identifier identifier) {
        if(identifier == null || !StringUtils.hasText(identifier.getText())) {
            return identifier;
        }
        String regex = "([a-z])(A-Z)";
        String replacement = "$1_S2";
        String newName = identifier.getText().replaceAll(regex,replacement)
                .toLowerCase();
        return Identifier.toIdentifier(newName);
    }

}
