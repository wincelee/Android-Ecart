package manu.apps.ecart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import manu.apps.ecart.R;
import manu.apps.ecart.classes.ProductCategory;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ProductViewHolder> {

    Context context;
    List<ProductCategory> productCategoryList;
    private RequestOptions requestOptions;


    public ProductCategoryAdapter(Context context, List<ProductCategory> productCategoryList) {
        this.context = context;
        this.productCategoryList = productCategoryList;

        requestOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_refresh_dark)
                .error(R.drawable.ic_refresh_dark);

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_layout,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.tvCategoryName.setText(productCategoryList.get(position).getProductName());

        Glide.with(context)
                .load(productCategoryList.get(position).getCategoryImage())
                .apply(requestOptions)
                .into(holder.imvCategoryImage);
    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView tvCategoryName;
        ImageView imvCategoryImage;

        public ProductViewHolder(@NonNull View itemView){
            super(itemView);

            tvCategoryName = itemView.findViewById(R.id.tv_category_name);
            imvCategoryImage = itemView.findViewById(R.id.imv_category_image);
        }
    }
}
