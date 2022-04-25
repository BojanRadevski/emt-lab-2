import React from "react";

const countries=(props)=>{
    return(
        <div className={"table table-striped"}>
            <thead>
            <th scope={"col"}>
                Name
            </th>
            <th scope={"col"}>
                Continent
            </th>
            </thead>
            <tbody>
            {props.countries.map((term) => {
                return (
                    <tr id={term.id}>
                        <td>{term.name}</td>
                        <td>{term.continent}</td>
                    </tr>
                )

            })}
            </tbody>
        </div>
    );
}
export default countries;