package teamagam.ConnectionTest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ConnectionTestActivity extends AppCompatActivity {

    private ConnectionTestFragment mSimpleTestFragment;
    private ConnectionTestFragment mProxyTestFragment;
    private ConnectionTestFragment mServerTestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragments();
        setTargets();
    }

    private void setFragments() {
        FragmentManager manager = getSupportFragmentManager();
        mSimpleTestFragment = (ConnectionTestFragment) manager.
                findFragmentById(R.id.simple_test_fragment);
        mProxyTestFragment = (ConnectionTestFragment) manager.
                findFragmentById(R.id.proxy_test_fragment);
        mServerTestFragment = (ConnectionTestFragment) manager.
                findFragmentById(R.id.server_test_fragment);
    }

    private void setTargets() {
        mSimpleTestFragment.setTarget("google.com");
        mProxyTestFragment.setTarget("cnn.com");
        mServerTestFragment.setTarget("ynet.co.il");
    }
}