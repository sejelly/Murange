//
'use strict';

const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: false }))

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  }

  const webcamElement = document.getElementById('webcam');
  const canvasElement = document.getElementById('canvas');
  const snapSoundElement = document.getElementById('snapSound');
  const webcam = new Webcam(webcamElement, 'user', canvasElement, snapSoundElement);

  webcam.start()
  .then(result =>{
     console.log("webcam started");
  })
  .catch(err => {
      console.log(err);
  });

  navigator.mediaDevices.enumerateDevices()
  .then(getVideoInputs)
  .catch(errorCallback);
 
function getVideoInputs(mediaDevices){
      mediaDevices.forEach(mediaDevice => {
        if (mediaDevice.kind === 'videoinput') {
          this._webcamList.push(mediaDevice);
        }
      });
}

navigator.mediaDevices.getUserMedia(this.getMediaConstraints())
  .then(stream => {
      this._webcamElement.srcObject = stream;
      this._webcamElement.play();
  })
  .catch(error => {
     //...
  });

  if(this._facingMode == 'user'){
    this._webcamElement.style.transform = "scale(-1,1)";
}

