package ccf.selelctimport;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public  class MyDeferredImportSelector implements DeferredImportSelector {


    public MyDeferredImportSelector (){}

    @Override
    public Class<? extends Group> getImportGroup() {
        return null;
    }


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{User.class.getName()};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }

    public static class MyGroup implements Group {

        public MyGroup(){}
        private final List<Entry> imports = new ArrayList<>();

        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("====");
            Entry entry = new Entry(metadata, User.class.getName());
            imports.add(entry);
        }

        @Override
        public Iterable<Entry> selectImports() {
            return this.imports;
        }
    }
}
