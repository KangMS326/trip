import React from "react";
import axios from "axios"; // import가 안 되면 안 돼

axios.defaults.withCredentials = true;

const Test = () => {

    // handler
    const getBtnClickHandler = () => {
        console.log('[Axios] getBtnClickHandler()');

        getData(); // axios로 비동기 통신하는 거 구현

    }

    const postBtnClickHandler = () => {
        console.log('[Axios] postBtnClickHandler()');

        postData(); // axios로 비동기 통신하는 거 구현

    }

    // axios
    async function getData() {
        console.log('[Axios] getData()');

        try {
            
            // get 방식이면 get을 사용하면 돼
           const response = await axios.get('http://localhost:8091/admin/test', {
                // get 방식일떄는 params를 이용해
                // 보낼 데이터를 나열해
                params: {
                    'id': 'gildong',
                }
                });
                
            console.log('[Axios] get communication succsee!');
            console.log('[Axios] response : ', response);

            console.log("data1: ", response.data.data1);
            console.log("data2: ", response.data.data2);
            console.log("data3: ", response.data.data3);

        } catch (e) {
            console.log('[Axios] get communication error!');
            console.log('[Axios] error : ', e);
        }
    }

    async function postData() {
        console.log('[Axios] postData()');

        try {
            
            // post 방식이라면 post 쓰면 돼.
           const response = await axios.get('http://localhost:8090/user/test', 
                // post 방식일떄는 params를 사용 못해
                // body에 직접 넣어야 해 
                {
                    'id': 'gildong',
                
                });
                
            console.log('[Axios] post communication succsee!');
            console.log('[Axios] response : ', response);

            console.log("data1: ", response.data.data1);
            console.log("data2: ", response.data.data2);
            console.log("data3: ", response.data.data3);

        } catch (e) {
            console.log('[Axios] post communication error!');
            console.log('[Axios] error : ', e);
        }
    }

    return(
        <>
            <br />
            <input type="button" value="ADMIN TEST BUTTON" onClick={getBtnClickHandler} /><br />
            <input type="button" value="USER TEST BUTTON" onClick={postBtnClickHandler} /><br />
        </>
    );
    
}
export default Test;
