package ccf.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class AppleLookup {

    @Lookup
    public abstract Apple getApple();

}
