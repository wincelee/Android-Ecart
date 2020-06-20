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
import manu.apps.ecart.classes.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> productList;
    private RequestOptions requestOptions;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;

        requestOptions = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_refresh_dark)
                .error(R.drawable.ic_refresh_dark);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.tvProductName.setText(productList.get(position).getProductName());
        holder.tvProductQty.setText(productList.get(position).getProductQty());
        holder.tvProductPrice.setText(productList.get(position).getProductPrice());

        Glide.with(context)
                .load(productList.get(position).getProductImage())
                .apply(requestOptions)
                .into(holder.imvProduct);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imvProduct;
        TextView tvProductName, tvProductQty,tvProductPrice;

        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            imvProduct = itemView.findViewById(R.id.imv_product);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductQty = itemView.findViewById(R.id.tv_product_qty);
            tvProductPrice= itemView.findViewById(R.id.tv_product_price);
        }
    }
}
