document.body.addEventListener('submit', (e) => {
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);
    console.log(data);
    form.reset();

    let endpoint = form.action;

    if (data['id']) {
        console.log('Replacing id in endpoint');
        endpoint = endpoint.replace('\{id\}', data['id']);
    }

    console.log('Endpoint: ' + endpoint);
    fetch(endpoint).then((response) => {
        console.log('Endpoint success response');
        console.log(response);
    }).catch((error) => {
        console.error('Endpoint failure');
        console.error(error);
    });
});