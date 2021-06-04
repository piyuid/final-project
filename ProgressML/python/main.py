import flask
from flask import request

app = flask.Flask(__name__)
app.config["DEBUG"] = True


@app.route('/', methods=['GET'])

def home():
    return "<h1>Distant Reading Archive</h1><p>This site is a prototype API for distant reading of science fiction novels.</p>"

    
import pandas as pd
import numpy as np
import os

import warnings
warnings.filterwarnings("ignore")
# df = pd.read_csv( 'rating.csv' , sep=';' )

# # df

# #df.to_csv("dataset_pilkada_ok.csv")

# df['label'] = df['Star'].astype(np.int64)
# #df = df.drop(["Unnamed: 0"],axis=1)

# # df.dtypes

# import re
# #menghapus RT
# df.Review = df.Review.str.replace(r'RT', '')
# #menghapus \n
# df.Review = df.Review.str.replace(r'\n', '')
# #menghapus link
# df.Review = df.Review.str.replace(r'https?:\/\/.*[\r\n]*',' ')
# #menghapus tanda mata uang dolar dll
# df.Review = df.Review.str.replace(r'\$\w*',' ')

# #lower case semua text
# df['Review'] = df['Review'].str.lower()

# # df.tail()

# df.Review.iloc[1]

# a = df['Star'].unique()
# # print(sorted(a))

# #rubah jadi array numpy, supaya bisa dilakukan modeling
# from sklearn.model_selection import train_test_split
# kalimat = df['Review'].values
# y = df['label'].values
# kalimat_latih, kalimat_test, y_latih, y_test = train_test_split(kalimat, y, test_size=0.2)

from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences


#tokeninzing menjadi perkata, dalma bentuk array
tokenizer = Tokenizer(num_words=250, oov_token='x')
# tokenizer.fit_on_texts(kalimat_latih) 
# # tokenizer.fit_on_texts(kalimat_test)

# #kita pecah perkalimat
# sekuens_latih = tokenizer.texts_to_sequences(kalimat_latih)
# sekuens_test = tokenizer.texts_to_sequences(kalimat_test)
# #kita bikin padding supaya setiap kalimat memiliki dimensi panjang yg sama
# padded_latih = pad_sequences(sekuens_latih) 
# padded_test = pad_sequences(sekuens_test)

# padded_latih.shape
# voc_size = padded_latih.max()+1
# print(voc_size)

# #membuat model Neural Network
# import tensorflow as tf
# model = tf.keras.Sequential([
# tf.keras.layers.Embedding(voc_size, 16, input_length=20),
# tf.keras.layers.LSTM(64),
# # tf.keras.layers.GlobalAveragePooling1D(),
# tf.keras.layers.Dense(24, activation='relu'),
# tf.keras.layers.Dense(1, activation='sigmoid')
# ])
# model.compile(loss='binary_crossentropy',optimizer='adam',metrics=['accuracy'])

# # #membuat model Neural Network
# # import tensorflow as tf
# # model = tf.keras.Sequential([
# #     tf.keras.layers.Embedding(voc_size, 16, input_length=20),
# #     tf.keras.layers.GlobalAveragePooling1D(),
# #     tf.keras.layers.Dense(24, activation='relu'),
# #     tf.keras.layers.Dense(1, activation='sigmoid')
# # ])
# # model.compile(loss='binary_crossentropy',optimizer='adam',metrics=['accuracy'])

# #melakukan pelatihan model NN sebanyak 30 kali epoch
# num_epochs = 30
# history = model.fit(padded_latih, y_latih, epochs=num_epochs, 
#             validation_data=(padded_test, y_test), verbose=2)

# import pickle
# weigh = model.get_weights();    pklfile= "modelweights.pkl"

# fpkl= open(pklfile, 'wb')    #Python 3     
# pickle.dump(weigh, fpkl, protocol= pickle.HIGHEST_PROTOCOL)
# fpkl.close()

# # model.save("my_model.h5") #using h5 extension
from keras.models import load_model
model = load_model('my_model.h5')

# #Tampilkan loss dari data training dan testing dalam bentuk plot
# from matplotlib import pyplot
# pyplot.plot(history.history['loss'], label='train')
# pyplot.plot(history.history['val_loss'], label='test')
# pyplot.legend()
# pyplot.show()

# #Tampilkan loss dari data training dan testing dalam bentuk plot
# from matplotlib import pyplot
# pyplot.plot(history.history['accuracy'], label='train')
# pyplot.plot(history.history['val_accuracy'], label='test')
# pyplot.legend()
# pyplot.show()

from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing import sequence



def predict_sentimen(kata):
    coba =[]
    kata = kata.replace('RT', ' ')
    kata = kata.replace('\n', ' ')
    kata = kata.replace('https?:\/\/.*[\r\n]*', ' ')
    kata = str.lower(kata)
    coba.append(kata)
    tokenizer.fit_on_texts(coba) 
    sequence_coba = tokenizer.texts_to_sequences(coba)
    padded_coba = pad_sequences(sequence_coba) 
    # padded_coba
    coba_hasil = sequence.pad_sequences(padded_coba)
    hasil_prediksi = model.predict(coba_hasil)[0][0]
    if hasil_prediksi > 0.6:
        sentimen = "Positif"
    else:
        sentimen = "Negatif"
    # print("Kalimat :\n", kata)
    # print("Sentimen :\n", sentimen)
    # print("Akurasi prediksi :\n",hasil_prediksi)
    return sentimen



@app.route('/get_sentimen')
def get_sentimen():
	# return "<h1> Ciluk Bwa </h1>"
	    # if key doesn't exist, returns None
    sentence = request.args.get('sentence')
    # return '''<h1>The language value is: {}</h1>'''.format(isian)
    return predict_sentimen(sentence)

if __name__ == '__main__':
  app.run(host='0.0.0.0', port=5002)