package helpme_productions.com.uberborrow.ribs.root.logged_in.borrow;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.List;

import helpme_productions.com.uberborrow.R;
import helpme_productions.com.uberborrow.model.CarInformation;

/**
 * Top level view for {@link BorrowBuilder.BorrowScope}.
 */
class BorrowView extends FrameLayout implements BorrowInteractor.BorrowPresenter {

    public BorrowView(Context context) {
        this(context, null);
    }

    public BorrowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorrowView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    @Override
//    public void setupRecyclerView(List<CarInformation> carInformationList) {
//        RecyclerView recyclerView = findViewById(R.id.rvCarsList);
//        RecyleAdapter adapter = new RecyleAdapter(carInformationList);
//        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(itemAnimator);
//    }
}
