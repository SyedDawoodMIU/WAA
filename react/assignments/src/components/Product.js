import React from "react";
import "../components/Product.css";

const Product = ({ product }) => {
  if (!product) {
    return <div>Product not found</div>;
  }

  const addToCart = () => {
    console.log("Add to cart clicked");
  };

  const removeFromCart = () => {};

  return (
    // Display the product
    <div className="product-block">
      <img
        className="product-image"
        src="https://picsum.photos/200/300"
        alt="product"
      />
      <h1 
        className="product-name"
      >{product.name}</h1>
      <h2
        className="product-price"
      >{product.price}</h2>
      <h3
        className="product-description"
      >{product.description}</h3>
      <button className="add-to-cart-button" onClick={addToCart}>
        Add to Cart
      </button>
      <button className="add-to-cart-button" onClick={removeFromCart}>
        Remove from Cart
      </button>
    </div>
  );
};

export default Product;
