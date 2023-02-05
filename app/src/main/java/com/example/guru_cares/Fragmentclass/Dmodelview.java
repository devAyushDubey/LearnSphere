package com.example.guru_cares.Fragmentclass;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;


import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.example.guru_cares.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dmodelview#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dmodelview extends Fragment {

    Context mcontext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Dmodelview() {
        // Required empty public constructor
    }

    public Dmodelview(Context context) {
        mcontext = context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dmodelview.
     */
    // TODO: Rename and change types and number of parameters
    public static Dmodelview newInstance(String param1, String param2) {
        Dmodelview fragment = new Dmodelview();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        PRDownloader.initialize(mcontext.getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_dmodelview, container, false);

        TextView enrollglobe = (TextView) v.findViewById(R.id.enrollglobe);
        TextView enrollsolar = (TextView) v.findViewById(R.id.enrollsolar);
        TextView enrollhistory = (TextView) v.findViewById(R.id.enrollhistory);
        TextView enrollchemistry = (TextView) v.findViewById(R.id.enrollchemistry);

        String api = "http://139.59.95.61:9090";



        enrollchemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.ChemistryAR");
                if (launchIntent != null) {
                    Toast.makeText(getContext(), "Starting Please wait...", Toast.LENGTH_SHORT).show();
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
                else
                {
                    checkPermission();
                    Toast.makeText(getContext(), "Downloading Module", Toast.LENGTH_SHORT).show();
                }


//                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.ChemistryAR");
//                if (launchIntent != null) {
//                    Toast.makeText(getContext(), "Starting Please wait...", Toast.LENGTH_SHORT).show();
//                    startActivity(launchIntent);//null pointer check in case package name was not found
//                }
//                else
//                {
//                    Toast.makeText(getContext(), "Null package name", Toast.LENGTH_SHORT).show();
//                }

            }
        });


        enrollsolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.SolarSystem");
                if (launchIntent != null) {
                    Toast.makeText(getContext(), "Starting Please wait...", Toast.LENGTH_SHORT).show();
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
                else
                {
                    Toast.makeText(getContext(), "Null package name", Toast.LENGTH_SHORT).show();
                }

            }
        });

        enrollhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.VRYoga");
                if (launchIntent != null) {
                    Toast.makeText(getContext(), "Starting Please wait...", Toast.LENGTH_SHORT).show();
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
                else
                {
                    Toast.makeText(getContext(), "Null package name", Toast.LENGTH_SHORT).show();
                }

            }
        });


        enrollglobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.Seasons");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
                else
                {
                    Toast.makeText(getContext(), "Null package name", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return v;
    }

    private void checkPermission() {
        Dexter.withContext(mcontext)
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                if(report.areAllPermissionsGranted()){
                    downloadApk();
                }
                else {
                    Log.e(getTag(),"Not all permissions are granted");
                    Toast.makeText(mcontext,"Please allow all permissions",Toast.LENGTH_SHORT).show();
                }
            }
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
    }

    private void downloadApk() {

        ProgressDialog pd = new ProgressDialog(mcontext);
        pd.setMessage("Downloading...");
        pd.setCancelable(false);
        pd.show();

        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        String url = "https://learnshpere.sgp1.digitaloceanspaces.com/download.apk";
        PRDownloader.download(url, file.getPath(), "package.apk")
                .build()
                .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                    @Override
                    public void onStartOrResume() {

                    }
                })
                .setOnPauseListener(new OnPauseListener() {
                    @Override
                    public void onPause() {

                    }
                })
                .setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel() {

                    }
                })
                .setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(Progress progress) {

                        long per = progress.currentBytes * 100 / progress.totalBytes;

                        pd.setMessage("Downloading : "+per+"%");
                    }
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Toast.makeText(mcontext, "Downloading Completed", Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                        Intent install = new Intent(Intent.ACTION_VIEW);
                        install.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                        install.setDataAndType(Uri.fromFile(new File(file.getPath() + "/package.apk")), "application/vnd.android.package-archive");
                        install.setDataAndType(FileProvider.getUriForFile(mcontext, mcontext.getApplicationContext().getPackageName() + ".provider", new File(file.getPath() + "/package.apk")),"application/vnd.android.package-archive");
                        startActivity(install);
                    }

                    @Override
                    public void onError(Error error) {
                        Log.e(getTag(),error.toString());
                        Toast.makeText(mcontext, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}