package com.sungwoo.aps.mobile.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sungwoo.aps.mobile.R;
import com.sungwoo.aps.mobile.SungwooApplication;
import com.sungwoo.aps.mobile.injection.compoment.ApplicationComponent;
import com.sungwoo.aps.mobile.injection.compoment.DaggerSungwooComponent;
import com.sungwoo.aps.mobile.injection.compoment.SungwooComponent;
import com.sungwoo.aps.mobile.injection.module.ActivityModule;

import javax.inject.Inject;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    protected SungwooComponent mSungwooComponent;

    Unbinder unbinder;

//    @Inject
//    SharedPreferences sharedPref;
//
//    @Inject
//    SharedPreferences.Editor editor;

    public static void start(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    /**
     * Make a Bundle for a single key/value pair.
     *
     * @hide
     */
    public static Bundle forPair(String key, String value) {
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }

    /**
     * Make a Bundle for a single key/value pair.
     *
     * @hide
     */
    public static Bundle forPair(String key, int value) {
        Bundle b = new Bundle(1);
        b.putInt(key, value);
        return b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((SungwooApplication) getApplication()).getComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected void showToast(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    protected void showMessageError(final Activity activity, final String message) {
        activity.runOnUiThread(() -> showDialog(activity, message));
    }

    /**
     * Show dialog as alert popup with message
     *
     * @param activity
     * @param message
     */
    public void showDialog(Activity activity, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message);
        builder.setCancelable(true);

        builder.setPositiveButton(activity.getResources().getString(R.string.dialog_option_ok),
                (dialog, id) -> dialog.cancel()
        );
        builder.setNegativeButton(activity.getResources().getString(R.string.dialog_option_cancel),
                (dialog, id) -> dialog.cancel()
        );
        final AlertDialog alert = builder.create();
        activity.runOnUiThread(() -> alert.show());
    }

    protected void showSnackBar(@NonNull View view, @StringRes int idLayout) {
        Snackbar.make(view, idLayout, Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show();
    }

    protected void initializeComponent() {
        this.mSungwooComponent = DaggerSungwooComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }
}
