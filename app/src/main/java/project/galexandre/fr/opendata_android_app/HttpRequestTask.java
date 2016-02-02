package project.galexandre.fr.opendata_android_app;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import project.galexandre.fr.opendata_android_app.model.Station;

public class HttpRequestTask extends AsyncTask<Void,Void, Station> {

    @Override
    protected Station doInBackground(Void...params){
        try{
            final String url = "http://warm-headland-98018.herokuapp.com/stations";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Station station = restTemplate.getForObject(url,Station.class);
            return station;
        }catch (Exception e){
            Log.e("MainActivity",e.getMessage(),e);
        }

        return null;

    }
    @Override
    protected void onPostExecute(Station station){
        TextView stationId = (TextView) findViewById(R.id.id_value);
        TextView stationAddress = (TextView) findViewById(R.id.address_value);
        stationId.setText(station.getId());
        stationAddress.setText(station.getAddress()+station.getCity());
    }

}
