package startup;

import com.google.inject.Inject;
import play.filters.cors.CORSFilter;
import play.http.DefaultHttpFilters;

public class FilterModule extends DefaultHttpFilters {

    @Inject
    public FilterModule(CORSFilter corsFilter) {
        super(corsFilter);
    }
}
