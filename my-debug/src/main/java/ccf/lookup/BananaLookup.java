package ccf.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public  class BananaLookup {

    @Lookup
    public  Banana getBanana(){
        return  new Banana();
    };

}
