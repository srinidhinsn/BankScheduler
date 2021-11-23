package com.distarise.bank.migration;

import com.distarise.bank.scheduler.BankJobTrigger;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;

public class Firebase {

    private Firestore firestore;
    private FirebaseDatabase firebaseDatabase;
    public static Logger logger = Logger.getLogger(Firebase.class.getName());
    public Firebase() {
        logger.info("Start -> Firebase.Firebase");
        try {
            logger.info("Reading service account");
            FileInputStream serviceAccount =
                    new FileInputStream(BankJobTrigger.firebaseServiceAccount);
            logger.info("Authenticating with url");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(BankJobTrigger.firebaseUrl)
                    .build();
            logger.info("Initializing app");
            FirebaseApp.initializeApp(options);
            firestore = FirestoreClient.getFirestore();
            firebaseDatabase = FirebaseDatabase.getInstance();

        } catch (IOException ioe) {
            ioe.printStackTrace();
            logger.error(ioe);
        }
        logger.info("End -> Firebase.Firebase");
    }

    public Firestore getFirestore() {
        return firestore;
    }

    public void setFirestore(Firestore firestore) {
        this.firestore = firestore;
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }

    public void setFirebaseDatabase(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }
}