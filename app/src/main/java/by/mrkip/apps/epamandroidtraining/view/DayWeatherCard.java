package by.mrkip.apps.epamandroidtraining.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.R;
import by.mrkip.apps.epamandroidtraining.contracts.IDayCardContract;
import by.mrkip.apps.epamandroidtraining.model.DayCard;
import by.mrkip.apps.epamandroidtraining.presenters.DayCardPresenter;

/**
 * Created by kip on 13.10.2016.
 */

public class DayWeatherCard extends CardView implements IDayCardContract.DayCardView {
	private IDayCardContract.Presenter presenter;

	private TextView tvDegree;
	private TextView tvHumisity;
	private TextView tvWindSpeed;
	private TextView tvDate;

	public String deg;
	public String hum;
	public String wind;


	public DayWeatherCard(Context context) {
		super(context);
		presenter = new DayCardPresenter(this);
		init();
	}

	public DayWeatherCard(Context context, AttributeSet attrs) {
		super(context, attrs);
		presenter = new DayCardPresenter(this);
		init();
	}

	public DayWeatherCard(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		presenter = new DayCardPresenter(this);
		init();


	}

	private void init() {


		presenter.onReady();


	}


	@Override
	public void showData(DayCard dayCard) {
		inflate(getContext(), R.layout.view_daycard, this);
		tvDegree = (TextView) findViewById(R.id.dwc_temperature);
		tvHumisity = (TextView) findViewById(R.id.dwc_humisity);
		tvWindSpeed = (TextView) findViewById(R.id.dwc_windspeed);
		tvDate = (TextView) findViewById(R.id.dwc_todaydate);

		//deg = String.valueOf(dayCard.getTempC());
		tvDegree.setText(dayCard.getTempC());
		//hum = String.valueOf(dayCard.getHumidity());
		tvHumisity.setText(dayCard.getHumidity());
		//wind = dayCard.getWindSpeed();
		tvWindSpeed.setText(dayCard.getWindSpeed());
		tvDate.setText(dayCard.getDate().toString());

	}

	@Override
	public void showError(String message) {

	}

	@Override
	public void showProgress(boolean isInProgress) {

	}
}
