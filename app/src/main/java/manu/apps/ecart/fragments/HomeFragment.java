package manu.apps.ecart.fragments;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import manu.apps.ecart.R;
import manu.apps.ecart.adapters.ProductCategoryAdapter;
import manu.apps.ecart.classes.ProductCategory;
import manu.apps.ecart.viewmodels.HomeViewModel;

public class HomeFragment extends Fragment {

    HomeViewModel homeViewModel;
    RecyclerView rvProductCategory;
    ProductCategoryAdapter productCategoryAdapter;
    List<ProductCategory> productCategoryList;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvProductCategory = view.findViewById(R.id.rv_product_category);

        productCategoryList = new ArrayList<>();

        loadProductCategories();

        setProductRecycler(productCategoryList);
    }

    private void loadProductCategories(){

        productCategoryList.add(new ProductCategory(1, R.drawable.ic_popular, "Most Popular"));
        productCategoryList.add(new ProductCategory(2, R.drawable.ic_body_products, "All Body Products"));
        productCategoryList.add(new ProductCategory(3, R.drawable.ic_skin_care, "Skin Care"));
        productCategoryList.add(new ProductCategory(4, R.drawable.ic_hair_product, "Hair"));

    }

    private void setProductRecycler(List<ProductCategory> productCategoryList){

        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        rvProductCategory.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(getActivity(), productCategoryList);
        rvProductCategory.setAdapter(productCategoryAdapter);

    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.home_fragment_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //productAdapter.getProductFilter().filter(newText);
                return true;
            }
        });


        // User return true when using it in activity
        //return true;

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_hair:
                Toast.makeText(getActivity(), "Voila am hair", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);

    }
}