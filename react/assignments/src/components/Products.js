import React from "react"
import Product from "./Product"

const Products = () => {
    
  const products = [
    {
      name: "Macbook Pro",
      price: 2000,
      description: "This is a very nice laptop"
    },
    {
      name: "Macbook Air",
      price: 1500,
      description: "This is a very nice laptop"
    },
  ]

    return (
        <div>
            {products.map((product) => (
                <Product product={product} />
            ))}
        </div>
    )

}

export default Products;
