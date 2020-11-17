package com.example.aidlserver.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.aidlserver.MultiplyInterface;

public class MultiplicationService extends Service {
    public MultiplicationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    MultiplyInterface.Stub myBinder = new MultiplyInterface.Stub() {
        @Override
        public int multiplyTwoValuesTogether(int firstNumber, int secondNumber)
                throws RemoteException {
            return firstNumber * secondNumber;
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MultiplicationService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
