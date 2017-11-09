package helpme_productions.com.uberborrow.ribs.root.logged_in.maps;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link MapBuilder.MapScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class MapRouter extends
        ViewRouter<MapView, MapInteractor, MapBuilder.Component> {

    public MapRouter(
            MapView view,
            MapInteractor interactor,
            MapBuilder.Component component) {
        super(view, interactor, component);
    }
}
