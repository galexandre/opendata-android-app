package project.galexandre.fr.opendata_android_app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import project.galexandre.fr.opendata_android_app.model.Gas;
import project.galexandre.fr.opendata_android_app.model.Station;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("Debug","On start");
        new HttpRequestTask().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, List<Station>> {

        @Override
        protected List<Station> doInBackground(Void... params) {
            Log.d("Debug","hi");
            try{
                final String url="https://warm-headland-98018.herokuapp.com/stations";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                List<Station> stations = (List<Station>) restTemplate.getForObject(url,Station.class);
                Log.d("Debug","Station:"+stations);
                return stations;
            }catch (Exception e){
                Log.e("Error",e.getMessage(),e);
                /***********
                 * CREATE A NEW OBJECT TO DISPLAY SOMETHING
                 * AND DON'T DISPLAY AN ERROR
                 ***********/
                List<Station> sts = new ArrayList<>();
                List<String> services = new ArrayList<>();
                services.add("");
                List<Gas> gas = new ArrayList<>();
                gas.add(new Gas("a gas", (float) 0));
                sts.add(new Station("a name", "id", 0, 0, "an address", "a city", "a cp", "open", services, gas));
                return sts;
            }
        }
        @Override
        protected void onPostExecute(List<Station> stations){
            Log.d("Debug","stat to put value on the fields");
            TextView textViewIdValue = (TextView) findViewById(R.id.id_value);
            TextView textViewAddressValue = (TextView) findViewById(R.id.address_value);
            textViewIdValue.setText(stations.get(0).getId());
            textViewAddressValue.setText(stations.get(0).getAddress()+" "+stations.get(0).getCp()+" "+
                    stations.get(0).getCity());
        }

    }
}