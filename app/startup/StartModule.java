package startup;

import com.google.inject.AbstractModule;
import services.LibraryManager;
import services.WestminsterLibraryManager;

public class StartModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(LibraryManager.class).to(WestminsterLibraryManager.class);
    }
}
