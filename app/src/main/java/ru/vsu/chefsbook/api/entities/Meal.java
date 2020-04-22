package ru.vsu.chefsbook.api.entities;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Meal implements Serializable {
    @SerializedName("name")
    @Expose
    private String name_;

    @SerializedName("category")
    @Expose
    private String category_;

    @SerializedName("country")
    @Expose
    private String country_;

    @SerializedName("recipe")
    @Expose
    private String recipe_;

    @SerializedName("tags")
    @Expose
    private String tags_;

    @SerializedName("ingredients")
    @Expose
    private String ingredients_;

    @SerializedName("youTube_url")
    @Expose
    private String youTube_url_;

    @SerializedName("image")
    @Expose
    private String imageUrl_;

    public Meal() {}

    public Meal(String name, String category, String country, String recipe, String tags, String ingedients, String youTube_url, String imageUrl)
    {
        this.name_ = name;
        this.category_ = category;
        this.country_ = country;
        this.recipe_ = recipe;
        this.tags_ = tags;
        this.ingredients_ = ingedients;
        this.youTube_url_ = youTube_url;
        this.imageUrl_ = imageUrl;
    }

    public String getName() {
        return name_;
    }

    public String getCategory() {
        return category_;
    }

    public String getCountry() {
        return country_;
    }

    public String getRecipe() {
        return recipe_;
    }

    public String getTags() {
        return tags_;
    }

    public String getIngredients() {
        return ingredients_;
    }

    public String getYouTube_url() {
        return youTube_url_;
    }

    public String getImageUrl() {
        return imageUrl_;
    }



    public void setName(String name) {
        this.name_ = name;
    }

    public void setCategory(String category) {
        this.category_ = category;
    }

    public void setCountry(String country) {
        this.country_ = country;
    }

    public void setRecipe(String recipe) {
        this.recipe_ = recipe;
    }

    public void setTags(String tags) {
        this.tags_ = tags;
    }

    public void setIngredients(String ingredients) {
        this.ingredients_ = ingredients;
    }

    public void setYouTube_url(String youTube_url) {
        this.youTube_url_ = youTube_url;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl_ = imageUrl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_, category_, country_, recipe_, tags_, ingredients_, youTube_url_, imageUrl_);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(name_, meal.name_) &&
                Objects.equals(category_, meal.category_) &&
                Objects.equals(country_, meal.country_) &&
                Objects.equals(recipe_, meal.recipe_) &&
                Objects.equals(tags_, meal.tags_) &&
                Objects.equals(ingredients_, meal.ingredients_) &&
                Objects.equals(youTube_url_, meal.youTube_url_) &&
                Objects.equals(imageUrl_, meal.imageUrl_);
    }
}
