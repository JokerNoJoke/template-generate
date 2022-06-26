package org.joker.template.generate.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joker.template.generate.db2j.Class;
import org.joker.template.generate.db2j.DataModel;
import org.joker.template.generate.db2j.DataModelResolverAdapter;
import org.joker.template.generate.db2j.DataTypeResolverAdapter;
import org.joker.template.generate.db2j.Field;
import org.joker.template.generate.freemarker.TemplateUtil;
import org.joker.template.generate.util.FileUtil;
import org.joker.template.generate.util.NameCaseUtil;

import freemarker.template.TemplateException;

public class MybatisGenerate {

        private DataModelResolverAdapter dataModelResolverAdapter = new DataModelResolverAdapter();
        private DataTypeResolverAdapter dataTypeResolverAdapter = new DataTypeResolverAdapter();

        public void generate(MybatisConfig mybatisConfig) throws TemplateException, IOException {
                DataModel dataModel = dataModelResolverAdapter
                                .resolver(mybatisConfig.getTableSchema(), mybatisConfig.getTableName());
                MybaitsDataModel mybaitsDataModel = buildMybaitsDataModel(mybatisConfig, dataModel);
                TemplateUtil.process("mybatis/entity.ftl", mybaitsDataModel,
                                FileUtil.getWriter(
                                                String.format("%s.java", mybaitsDataModel.getEntity().getClassName())));
                TemplateUtil.process("mybatis/mapper.ftl", mybaitsDataModel,
                                FileUtil.getWriter(
                                                String.format("%s.java", mybaitsDataModel.getMapper().getClassName())));
                TemplateUtil.process("mybatis/mapper.xml.ftl", mybaitsDataModel,
                                FileUtil.getWriter(
                                                String.format("%s.xml", mybaitsDataModel.getMapper().getClassName())));
        }

        private MybaitsDataModel buildMybaitsDataModel(MybatisConfig mybatisConfig, DataModel dataModel) {
                MybaitsDataModel mybaitsDataModel = new MybaitsDataModel();
                mybaitsDataModel.setConfig(mybatisConfig);
                mybaitsDataModel.setTable(dataModel.getTable());
                mybaitsDataModel.setColumns(dataModel.getColumns());
                String defultClassName = NameCaseUtil
                                .underscorecaseToUppercamelcase(dataModel.getTable().getTableName());
                Class entity = new Class();
                entity.setPackageName(mybatisConfig.getEntityPackage());
                entity.setClassName(StringUtils.isBlank(mybatisConfig.getEntityClass()) ? defultClassName
                                : mybatisConfig.getEntityClass());
                entity.setClassComment(String.format("%s - Entity", dataModel.getTable().getTableComment()));
                mybaitsDataModel.setEntity(entity);
                Class mapper = new Class();
                mapper.setPackageName(mybatisConfig.getMapperPackage());
                mapper.setClassName(StringUtils.isBlank(mybatisConfig.getMapperClass())
                                ? String.format("%sMapper", defultClassName)
                                : mybatisConfig.getMapperClass());
                mapper.setClassComment(String.format("%s - Entity", dataModel.getTable().getTableComment()));
                mybaitsDataModel.setMapper(mapper);
                List<Field> fields = dataModel.getColumns().stream().map(m -> {
                        Field field = new Field();
                        field.setType(dataTypeResolverAdapter.resolver(m.getDataType()));
                        field.setFieldName(NameCaseUtil.underscorecaseToLowercamelcase(m.getColumnName()));
                        field.setFieldComment(m.getColumnComment());
                        return field;
                }).toList();
                mybaitsDataModel.setFields(fields);
                return mybaitsDataModel;
        }

}
