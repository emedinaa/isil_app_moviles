package com.isil.isilpractica01;

/**
 * @author : Eduardo José Medina Alfaro
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class Practica1Activity extends Activity implements OnClickListener {

	private EditText txtEmail,txtPassword,txtPassword2,txtName,txtLastName,txtPhone;
	private Button btnRegister,btnCancel;
	private Animation animationShake;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practica1);
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		txtEmail=(EditText)findViewById(R.id.txtEmail);
		txtPassword=(EditText)findViewById(R.id.txtPassword);
		txtPassword2=(EditText)findViewById(R.id.txtPassword2);
		txtName=(EditText)findViewById(R.id.txtName);
		txtLastName=(EditText)findViewById(R.id.txtLastName);
		txtPhone=(EditText)findViewById(R.id.txtPhone);
		
		btnRegister=(Button)findViewById(R.id.btnRegister);
		btnCancel=(Button)findViewById(R.id.btnCancel);
		
		//events
		btnRegister.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		
		//animation
		animationShake = AnimationUtils.loadAnimation(this, R.anim.shake); 
	}
	private boolean validateRegister()
	{
		String email=txtEmail.getText().toString();
		String password=txtPassword.getText().toString();
		String password2=txtPassword2.getText().toString();
		String name=txtName.getText().toString();
		String lastName=txtLastName.getText().toString();
		String phone=txtPhone.getText().toString();
		
		if(email.equals("") || email.length()<=RegisterRules.RULE_EMAIL_MIN)
		{
			ToastAlertUtils.make(this, RegisterRules.ERROR_EMAIL);
			txtEmail.startAnimation(animationShake); 
			return false;
		}
		if(password.equals("") || password.length()<=RegisterRules.RULE_PASSWORD_MIN)
		{
			ToastAlertUtils.make(this, RegisterRules.ERROR_PASSWORD);
			txtPassword.startAnimation(animationShake); 
			return false;
		}
		if(password2.equals("") || password2.length()<=RegisterRules.RULE_PASSWORD_MIN)
		{
			ToastAlertUtils.make(this, RegisterRules.ERROR_PASSWORD);
			txtPassword2.startAnimation(animationShake);
			return false;
		}
		if(!password.equals(password2))
		{
			ToastAlertUtils.make(this, RegisterRules.ERROR_PASSWORDEQUALS);
			txtPassword2.startAnimation(animationShake);
			return false;
		}
		
		if(name.equals("") || name.length()<=RegisterRules.RULE_USERNAME_MIN)
		{
			ToastAlertUtils.make(this, RegisterRules.ERROR_USERNAME);
			txtName.startAnimation(animationShake);
			return false;
		}
		
		if(lastName.equals("") || lastName.length()<=RegisterRules.RULE_USERNAME_MIN)
		{
			ToastAlertUtils.make(this, RegisterRules.ERROR_USERNAME);
			txtLastName.startAnimation(animationShake);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practica1, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		if(view.getId()==R.id.btnRegister)
		{
			if(validateRegister())
			{
				sendRegister();
			}
		}else if(view.getId()==R.id.btnCancel)
		{
			cancel();
		}
	}

	private void sendRegister() {
		// TODO Auto-generated method stub
		ToastAlertUtils.make(this, "Registrando Usuario...");
		clearForm();
	}

	private void clearForm() {
		// TODO Auto-generated method stub
		txtEmail.setText("");
		txtPassword.setText("");
		txtPassword2.setText("");
		txtName.setText("");
		txtLastName.setText("");
		txtEmail.requestFocus();
	}

	private void cancel() {
		// TODO Auto-generated method stub
		clearForm();
	}

}
