package com.example.chaminhwan_kakaostory.fgm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chaminhwan_kakaostory.R;

public class fgm01_home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fgm01_home, container, false);
    }



   /* public void go_Camera(){
        //카메라 앱을 실행할때는 파일을 만들어서 보내줘야함. (그파일 형태에 이미지 채움)
        Intent cIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //권한을 가지고 있으면서 해당하는 인텐트 서비스를 사용할수있는지 체크
        if(cIntent.resolveActivity(getPackageManager()) != null){
            File imgFile = createFile();
            if(imgFile != null){
                Uri imgUri = FileProvider.getUriForFile(getApplicationContext() ,
                        getApplicationContext().getPackageName()+ ".fileprovider",imgFile );
                //만약에 API24 이상이면
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    cIntent.putExtra(MediaStore.EXTRA_OUTPUT , imgUri);
                }else{
                    cIntent.putExtra(MediaStore.EXTRA_OUTPUT , Uri.fromFile(imgFile));
                }
                startActivityForResult(cIntent , CAMERA_REQ);
            }

        }
    }

    File createFile(){
        //파일 이름을 만들기 위한 처리.
        String timeStamp = new SimpleDateFormat("yyyyMMdd HHmmss")
                .format(new Date());
        String uid = UUID.randomUUID().toString();
        //어떤 파일이나 값을 식별하기위한 고유식별자로 많이 사용됨 (중복값이 나오면 안되는 경우에 )
        String imageFileName = "My" + timeStamp;

        //사진 파일을 저장하기 위한 경로
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File curFile = null;
        try{
            // 임시 파일을 생성함(전체경로 ) , 2번째 suffix 확장자
            curFile = File.createTempFile(imageFileName , ".jpg" , storageDir);
        }catch (IOException e){

        }
        //Multipart에 보내기 위한 임시파일이 있는 곳의 절대경로를 저장하는 로직이 필요함.(String)

        return curFile;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_IMG && resultCode == RESULT_OK){
            Toast.makeText(JoinActivity.this, "이미지 가져오기 성공.", Toast.LENGTH_SHORT).show();
            Uri galleryUri = data.getData();
            Glide.with(JoinActivity.this).load(galleryUri).into(imgv_profile);
        }else if(requestCode == CAMERA_REQ && resultCode == RESULT_OK){
            Toast.makeText(JoinActivity.this, "사진을 찍어서 가지고오긴함.", Toast.LENGTH_SHORT).show();
            //갤러리에 사진을 저장하고 저장한 Uri를 통해서 다시 Glide를 통해 붙이기
            //Uri gellaryAddpic메소드 하기전 .. 담주진행.
        }

    }

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }*/
}