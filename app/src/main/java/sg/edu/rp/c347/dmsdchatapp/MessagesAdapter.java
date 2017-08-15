package sg.edu.rp.c347.dmsdchatapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 15004543 on 15/8/2017.
 */

public class MessagesAdapter extends ArrayAdapter<Messages> {
    Context context;
    int layoutResourceId;
    ArrayList<Messages> messagesList;

    public MessagesAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Messages> postList) {
        super(context, resource, postList);
        this.layoutResourceId = resource;
        this.context = context;
        this.messagesList = postList;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        MessagesHolder holder = null;

        if (row == null ){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new MessagesHolder();

            holder.tvName = (TextView) row.findViewById(R.id.tvName);
            holder.tvTime = (TextView) row.findViewById(R.id.tvTime);
            holder.etText = (EditText) row.findViewById(R.id.etText);

            row.setTag(holder);

        } else {
            holder = (MessagesHolder) row.getTag();
        }

        Messages message = messagesList.get(position);
        holder.etText.setEnabled(false);
        holder.tvName.setText(message.getUser());
        holder.tvTime.setText(message.getTime());
        holder.etText.setText(message.getText());

        return row;
    }
    static class MessagesHolder {
        TextView tvName, tvTime;
        EditText etText;
    }
}
