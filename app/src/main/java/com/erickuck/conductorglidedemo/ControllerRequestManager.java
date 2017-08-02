package com.erickuck.conductorglidedemo;

import android.support.annotation.NonNull;
import android.view.View;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Controller.LifecycleListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

public class ControllerRequestManager {

    public static RequestManager with(Controller controller) {
        if (controller.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load until the Controller has been bound to a Context.");
        } else {
            final RequestManager requestManager = Glide.with(controller.getActivity());
            controller.addLifecycleListener(new LifecycleListener() {
                @Override
                public void postCreateView(@NonNull Controller controller, @NonNull View view) {
                    requestManager.onStart();
                }

                @Override
                public void preDestroyView(@NonNull Controller controller, @NonNull View view) {
                    requestManager.onStop();
                }

                @Override
                public void preDestroy(@NonNull Controller controller) {
                    requestManager.onDestroy();
                    controller.removeLifecycleListener(this);
                }
            });
            return requestManager;
        }
    }

}
