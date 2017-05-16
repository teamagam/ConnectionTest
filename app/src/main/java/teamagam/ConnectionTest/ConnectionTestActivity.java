package teamagam.ConnectionTest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ConnectionTestActivity extends AppCompatActivity {

    private ConnectionTestFragment mSimpleTestFragment;
    private ConnectionTestFragment mProxyTestFragment;

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
    }

    private void setTargets() {
        mSimpleTestFragment.setTitle(getString(R.string.simple_test_title));
        mSimpleTestFragment.setNewTarget(getString(R.string.simple_test_target));
        mProxyTestFragment.setTitle(getString(R.string.proxy_test_title));
        mProxyTestFragment.setNewTarget(getString(R.string.proxy_test_target));
    }
}