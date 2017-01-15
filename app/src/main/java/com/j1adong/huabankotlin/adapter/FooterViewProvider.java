package com.j1adong.huabankotlin.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.j1adong.huabankotlin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by J1aDong on 2017/1/14.
 */

public class FooterViewProvider
		extends ItemViewProvider<Footer, FooterViewProvider.ViewHolder>
{

	@NonNull
	@Override
	protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater,
			@NonNull ViewGroup parent)
	{
		View root = inflater.inflate(R.layout.view_footer, parent, false);
		return new ViewHolder(root);
	}

	@Override
	protected void onBindViewHolder(@NonNull ViewHolder holder,
			@NonNull Footer footer)
	{
		if( footer.getType().equals(Footer.LoadMore) )
		{
			holder.container.removeAllViews();
			View view = LayoutInflater.from(holder.itemView.getContext())
					.inflate(R.layout.view_load_more, holder.container, true);
		}
		else
		{
			holder.container.removeAllViews();
		}
	}

	static class ViewHolder extends RecyclerView.ViewHolder
	{
		@BindView(R.id.container)
		LinearLayout container;

		public ViewHolder(View itemView)
		{
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
