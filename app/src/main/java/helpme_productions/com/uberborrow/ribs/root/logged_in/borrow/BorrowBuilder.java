package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.ViewBuilder;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Provides;
import helpme_productions.com.uberborrow.R;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Builder for the {@link BorrowScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
public class BorrowBuilder
        extends ViewBuilder<BorrowView, BorrowRouter, BorrowBuilder.ParentComponent> {

    public BorrowBuilder(ParentComponent dependency) {
        super(dependency);
    }

    /**
     * Builds a new {@link BorrowRouter}.
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new {@link BorrowRouter}.
     */
    public BorrowRouter build(ViewGroup parentViewGroup) {
        BorrowView view = createView(parentViewGroup);
        BorrowInteractor interactor = new BorrowInteractor();
        Component component = DaggerBorrowBuilder_Component.builder()
                .parentComponent(getDependency())
                .view(view)
                .interactor(interactor)
                .build();
        return component.borrowRouter();
    }

    @Override
    protected BorrowView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
        // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
        // provided context from the parentViewGroup.
        return (BorrowView) inflater.inflate(R.layout.borrow_rib, parentViewGroup, false);
    }

    public interface ParentComponent {
      BorrowInteractor.BorrowListener BorrowStartListener();
    }

    @dagger.Module
    public abstract static class Module {

        @BorrowScope
        @Binds
        abstract BorrowInteractor.BorrowPresenter presenter(BorrowView view);

        @BorrowScope
        @Provides
        static BorrowRouter router(
            Component component,
            BorrowView view,
            BorrowInteractor interactor) {
            return new BorrowRouter(view, interactor, component);
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @BorrowScope
    @dagger.Component(modules = Module.class,
           dependencies = ParentComponent.class)
    interface Component extends InteractorBaseComponent<BorrowInteractor>, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            Builder interactor(BorrowInteractor interactor);
            @BindsInstance
            Builder view(BorrowView view);
            Builder parentComponent(ParentComponent component);
            Component build();
        }
    }

    interface BuilderComponent  {
        BorrowRouter borrowRouter();
    }

    @Scope
    @Retention(CLASS)
    @interface BorrowScope { }

    @Qualifier
    @Retention(CLASS)
    @interface BorrowInternal { }
}
