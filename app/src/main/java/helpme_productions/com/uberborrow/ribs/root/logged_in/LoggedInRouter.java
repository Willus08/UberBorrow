package helpme_productions.com.uberborrow.ribs.root.logged_in;

import android.view.ViewGroup;

import com.uber.rib.core.Router;

import helpme_productions.com.uberborrow.ribs.root.RootView;
import helpme_productions.com.uberborrow.ribs.root.logged_in.borrow.BorrowBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_in.borrow.BorrowRouter;
import helpme_productions.com.uberborrow.ribs.root.logged_in.maps.MapBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_in.maps.MapRouter;
import helpme_productions.com.uberborrow.ribs.root.logged_in.renter.RenterBuilder;
import helpme_productions.com.uberborrow.ribs.root.logged_in.renter.RenterRouter;
import helpme_productions.com.uberborrow.ribs.root.logged_in.return_vehicle.ReturnVehicleBuilder;

/**
 * Adds and removes children of {@link LoggedInBuilder.LoggedInScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
public class LoggedInRouter
        extends Router<LoggedInInteractor, LoggedInBuilder.Component> {

    private final ViewGroup parentView;
    private BorrowBuilder borrowBuilder;
    private MapBuilder mapBuilder;
    private RenterBuilder renterBuilder;
    ReturnVehicleBuilder returnVehicleBuilder;
    private MapRouter mapRouter;
    private RenterRouter renterRouter;
    private BorrowRouter borrowRouter;


    public LoggedInRouter(
            LoggedInInteractor interactor,
            LoggedInBuilder.Component component,
            RootView rootView,
            RenterBuilder renterBuilder,
            BorrowBuilder borrowBuilder,
            MapBuilder mapBuilder) {
        super(interactor, component);
        this.parentView = rootView;
        this.renterBuilder =renterBuilder;
        this.borrowBuilder = borrowBuilder;
        this.mapBuilder = mapBuilder;

    }

    public void attachMap(){
        mapRouter = mapBuilder.build(parentView);
        attachChild(mapRouter);
        parentView.addView(mapRouter.getView());
    }

    public void attachRenter(){
        renterRouter = renterBuilder.build(parentView);
        attachChild(renterRouter);
        parentView.addView(renterRouter.getView());
    }

    public void attachBorrower(){
        borrowRouter = borrowBuilder.build(parentView);
        attachChild(borrowRouter);
        parentView.addView(borrowRouter.getView());
    }

    public void attachReturnVehicle(){}

    public void detachMap(){
        if (mapRouter != null) {
            detachChild(mapRouter);
            parentView.removeView(mapRouter.getView());
            mapRouter = null;
        }

    }

    public void detachRenter(){
        if(renterRouter != null){
            detachChild(renterRouter);
            parentView.removeView(renterRouter.getView());
            renterRouter = null;
        }
    }

    public void detachBorrower(){
        if(borrowRouter != null){
            detachChild(borrowRouter);
            parentView.removeView(borrowRouter.getView());
            borrowRouter = null;
        }
    }

    public void detatchReturnVehicle(){}

}
