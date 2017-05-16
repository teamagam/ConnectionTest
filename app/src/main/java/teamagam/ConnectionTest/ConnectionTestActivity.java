package teamagam.ConnectionTest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ConnectionTestActivity extends AppCompatActivity {

    private ConnectionTestFragment mEncoderTestFragment;
    private ConnectionTestFragment mNetworkTestFragment;
    private ConnectionTestFragment mProxyTestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupTestEnvironment();
    }

    private void setupTestEnvironment() {
        setFragments();
        setTitles();
        setTargets();
    }

    private void setFragments() {
        FragmentManager manager = getSupportFragmentManager();
        mEncoderTestFragment = (ConnectionTestFragment) manager.
                findFragmentById(R.id.encoder_test_fragment);
        mNetworkTestFragment = (ConnectionTestFragment) manager.
                findFragmentById(R.id.network_test_fragment);
        mProxyTestFragment = (ConnectionTestFragment) manager.
                findFragmentById(R.id.proxy_test_fragment);
    }

    private void setTitles() {
        mEncoderTestFragment.setTitle(getString(R.string.encoder_test_title));
        mNetworkTestFragment.setTitle(getString(R.string.network_test_title));
        mProxyTestFragment.setTitle(getString(R.string.proxy_test_title));
    }

    private void setTargets() {
        mEncoderTestFragment.setNewTarget(getString(R.string.encoder_test_target));
        mNetworkTestFragment.setNewTarget(getString(R.string.network_test_target));
        mProxyTestFragment.setNewTarget(getString(R.string.proxy_test_target));
    }
}