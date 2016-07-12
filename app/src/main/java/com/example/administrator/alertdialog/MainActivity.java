package com.example.administrator.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.btn_custom_adapter_dialog)
    Button btn_custom;
    @Bind(R.id.btn_custom_view_dialog)
    Button btnCustomView;
    @Bind(R.id.btn_multi_choice_dialog)
    Button btnMulti;
    @Bind(R.id.btn_simple_dialog)
    Button btnSimple;
    @Bind(R.id.btn_simple_list_dialog)
    Button btnSimpleList;
    @Bind(R.id.btn_single_choice_dialog)
    Button btnSingle;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_custom_adapter_dialog, R.id.btn_custom_view_dialog, R.id.btn_multi_choice_dialog
            , R.id.btn_simple_dialog, R.id.btn_simple_list_dialog, R.id.btn_single_choice_dialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_dialog:
                showSimpleDialog(view);
                break;
            case R.id.btn_simple_list_dialog:
                showSimpleListDialog(view);
                break;
            case R.id.btn_single_choice_dialog:
                showSingleChoiceDialog(view);
                break;
            case R.id.btn_multi_choice_dialog:
                showMultiChoiceDialog(view);
                break;
            case R.id.btn_custom_adapter_dialog:
                showCustomAdapterDialog(view);
                break;
            case R.id.btn_custom_view_dialog:
                showCustomViewDialog(view);
                break;
        }
    }

    private void showCustomViewDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.custom_view_dialog);

        /**
         * 设置内容区域为自定义View
         */
        LinearLayout loginDialog= (LinearLayout) getLayoutInflater().inflate(R.layout.custom_view,null);
        builder.setView(loginDialog);

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showCustomAdapterDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.custom_adapter_dialog);

        /**
         * 设置内容区域为自定义adapter
         */
        List<ItemBean> items=new ArrayList<>();
        items.add(new ItemBean(R.mipmap.ic_launcher,"You can call me xiaoming"));
        items.add(new ItemBean(R.mipmap.ic_launcher, "I'm android xiao"));
        CustomAdapter adapter=new CustomAdapter(items,getApplicationContext());
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You clicked"+i,Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showMultiChoiceDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.simple_list_dialog);

        /**
         * 设置内容区域为多选列表项
         */
        final String[] items={"Items_one","Items_two","Items_three"};
        builder.setMultiChoiceItems(items, new boolean[]{true, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(getApplicationContext(),"You clicked "+items[i]+" "+b,Toast.LENGTH_SHORT).show();
            }
        });


        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showSingleChoiceDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.single_choice_dialog);

        /**
         * 设置内容区域为单选列表项
         */
        final String[] items={"Items_one","Items_two","Items_three"};
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You clicked "+items[i], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private void showSimpleListDialog(View view) {
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.simple_list_dialog);

        final String[] Items = {"Items_one", "Items_two", "Items_three"};
        builder.setItems(Items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext()
                        , "You clicked " + Items[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showSimpleDialog(View view) {
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(R.string.simple_dialog);
        builder.setMessage(R.string.dialog_message);

        builder.setPositiveButton(R.string.postive_button, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.toast_postive
                        , Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), R.string.toast_negative
                        , Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
