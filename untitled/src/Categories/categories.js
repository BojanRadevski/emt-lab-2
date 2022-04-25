import React from "react";

const categories=(props)=>{
    return(
        <ol>
            {props.categories.map((term)=>{
                return(
                    <li>{term}</li>
                )
            })}
        <li>Test</li>
        </ol>
    );
}
export default categories;