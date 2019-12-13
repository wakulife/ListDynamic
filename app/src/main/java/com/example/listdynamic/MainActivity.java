package com.example.listdynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        //リスト項目をArrayListとして準備
        ArrayList<String> data = new ArrayList<> () ;
        data.add("胡椒");
        data.add("ターメリック");
        data.add("コリアンダー");
        data.add("生姜");
        data.add("ニンニク");
        data.add("サフラン");

        //配列アダプターを生成
        final ArrayAdapter<String> adapter = new ArrayAdapter<> (
                //第１引数：アクティビティ
                this,
                //第２引数：レイアウト
                android.R.layout.simple_list_item_single_choice,
                //第３引数：データ
                data);
        //ListViewへアダプターを登録
        ListView list = findViewById (R.id.list) ;
        list.setAdapter (adapter);

        //リスト項目をクリックしたときの処理を定義

        list.setOnItemClickListener (
                new AdapterView.OnItemClickListener (){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CharSequence msg = ((TextView) view).getText ();
                        Toast.makeText (MainActivity.this,
                                String.format ("選択したものは%s" , msg.toString ()),
                                Toast.LENGTH_SHORT).show ();

                    }
                }

        );

    }
}
